package a.sharafutdinov;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by innopolis on 15.02.17.
 */
public class AnimalLoader extends  ClassLoader {
    private String jarFile = "Animal.jar";
    private Hashtable classes = new Hashtable();

    public AnimalLoader() {
        super(AnimalLoader.class.getClassLoader());

    }
    public Class loadCls(String className) throws ClassNotFoundException {
        return findCls(className);
    }
    public Class findCls(String className) {
        byte classByte[];
        Class rlt = null;

        rlt = (Class) classes.get(className);
        if(rlt != null){
            return null;
        }
        try {
            return findSystemClass(className);
        } catch (Exception e) {

        }
        try {
            JarFile jar = new JarFile(jarFile);
            JarEntry entry = jar.getJarEntry(className + ".class");
            InputStream is = jar.getInputStream(entry);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nexValue = is.read();
            while (-1 != nexValue) {
                byteStream.write(nexValue);
                nexValue = is.read();
            }

            classByte = byteStream.toByteArray();
            rlt = defineClass(className, classByte, 0, classByte.length, null);
            classes.put(className, rlt);
            return rlt;
        } catch (Exception e) {
            return null;
        }

    }




}
