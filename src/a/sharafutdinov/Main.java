package a.sharafutdinov;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;

public class Main {
    //private static final String SERIALIZED_FILE_NAME="animal1.xml";

    public static void main(String[] args) {
        String classPath = "https://github.com/tmars/JavaClassLoader/raw/master/animal.jar";
        String className = "com.talipov.Animal1";

        AnimalLoader cl = new AnimalLoader();
        Class cls = cl.findCls(className);
        ListAnimal listAnimal = new ListAnimal();
        listAnimal.serialize("animal2.xml");

    }
}
