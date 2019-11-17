package com.compalex.bookLibrary.di;

import java.lang.reflect.Field;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.di.InjectStrategy;
import com.compalex.bookLibrary.utility.Constants;
import com.compalex.bookLibrary.utility.Constants.Layer;
import org.reflections.util.ClasspathHelper;

public class InjectionHandler {   
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
    public static void doInjection() {
        Set<Field> fields = getAnnotatedFields();
        System.out.println(fields);
        for(Field field : fields) {
            field.setAccessible(true);
            InjectStrategy injStrategy = getStrategy(field.getAnnotation(Inject.class).layer());
            try {
                Object objToInject = injStrategy.getInjectObject(field.getAnnotation(Inject.class).type());
                Object declaringObj = field.getDeclaringClass().getMethod(Constants.GET_INSTANCE_METHOD).invoke(null);
                field.set(declaringObj, objToInject);
            } catch(Exception e) {
               logger.error(e);
            }
        }
    }
    
    private static InjectStrategy getStrategy(Layer layer) {
        switch(layer) {
            case DAO:
                return new StrategyInjectDAO();
            case SERVICE:
                return new StrategyInjectService(); 
            default:
                return null;
        }
    }

    private static Set<Field> getAnnotatedFields() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setScanners(new FieldAnnotationsScanner());
        configurationBuilder.setUrls(ClasspathHelper.forPackage(Constants.PACKAGE_NAME));
        Reflections reflections = new Reflections(configurationBuilder);
        return reflections.getFieldsAnnotatedWith(Inject.class);
    }
}
