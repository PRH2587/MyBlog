package com.bomb.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


public class PackageUtil {

    static final String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
    static final String DEFAULT_DUMMY_PLACEHOLDER = "*";
    static final String ALL_CLASS_SURFFIX = "/**/*.class";

    public static List<String> getPackages(String basePackage, boolean mapperAllClasses) {
        List<String> packages = new ArrayList<String>();
        // ---------------------------------------------------------------------------------------------------------------------------------------
        String[] basePackages = basePackage.split(",");
        for (String packageStr : basePackages) {
            packages = processPackages(packages, packageStr, mapperAllClasses);
        }
        // ---------------------------------------------------------------------------------------------------------------------------------------
        return packages;
    }

    protected static List<String> processPackages(List<String> packages, String basePackage, boolean mapperAllClasses) {
        if (basePackage == null || basePackage.lastIndexOf(DEFAULT_DUMMY_PLACEHOLDER) < 0) {
            packages.add(basePackage);
            // ---------------------------------------------------------------------------------------------------------------------------------------
            return packages;
        }
        // ---------------------------------------------------------------------------------------------------------------------------------------
        basePackage = basePackage.replace(".", "/");
        String rootDirPath = determineRootDir(basePackage);
        String suffixDirPath = basePackage.substring(basePackage.lastIndexOf(DEFAULT_DUMMY_PLACEHOLDER) + 1);
        // ---------------------------------------------------------------------------------------------------------------------------------------
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/" + basePackage + (mapperAllClasses ? ALL_CLASS_SURFFIX : ""));
            for (Resource resource : resources) {
                String url = resource.getURL().toString();
                int start = url.lastIndexOf(rootDirPath);
                if (start < 0) continue;
                int end = url.lastIndexOf(suffixDirPath);
                String packageStr = url.substring(start, end + suffixDirPath.length());
                if (packages.contains(packageStr.replace("/", ".")) == false) packages.add(packageStr.replace("/", "."));
            }
        } catch (IOException e) {
            //
        }
        // ---------------------------------------------------------------------------------------------------------------------------------------
        return packages;
    }

    protected static String determineRootDir(String location) {
        int prefixEnd = location.indexOf(":") + 1;
        int rootDirEnd = location.length();
        // --------------------------------------------------------------------------------------------------------------------
        while (rootDirEnd > prefixEnd && isPattern(location.substring(prefixEnd, rootDirEnd))) {
            rootDirEnd = location.lastIndexOf('/', rootDirEnd - 2) + 1;
        }
        if (rootDirEnd == 0) {
            rootDirEnd = prefixEnd;
        }
        // --------------------------------------------------------------------------------------------------------------------
        return location.substring(0, rootDirEnd);
    }

    protected static boolean isPattern(String path) {
        return (path.indexOf('*') != -1 || path.indexOf('?') != -1);
    }

    public static void main(String[] args) {
        List<String> list = getPackages("com.bravowhale.**.model", true);
        System.out.println(list);
    }
}
