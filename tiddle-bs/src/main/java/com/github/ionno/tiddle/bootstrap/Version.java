package com.github.ionno.tiddle.bootstrap;

import java.io.Serializable;
import java.util.Objects;

// TODO: DOCS
final class Version implements Comparable<Version>, Serializable {
    
    private final String VERSION_PATTERN = "[0-9]+(\\.[0-9]+)*";
    private final String SPLIT_PATTERN = "\\.";
    
    private final String version;

    public Version(String version){
        version = Objects.requireNonNull(version, "The version cannot be null.");
        
        if(!version.matches(VERSION_PATTERN))
            throw new IllegalArgumentException("Invalid version format.");
        
        this.version = version;
    }

    public String get(){
        return version;
    }
    
    /**
     * Compare the {@code version} value from two {@code Version} objects.
     * 
     * @param other
     *      The other version to be verified.
     * 
     * @return 
     *      {@code -1} if the value of the {@code other} version is higher.
     *      {@code  0} if the value of the {@code other} version is equal.
     *      {@code  1} if the value of the {@code other} version is below.
     */
    @Override
    public int compareTo(Version other) {
        
        if(other == null) return 1;
        
        String thisVersion[] = get().split(SPLIT_PATTERN),
               otherVersion[] = other.get().split(SPLIT_PATTERN);
        
        int size = Math.max(thisVersion.length, otherVersion.length);
        for(int index = 0; index < size; index++){
            
            int ver = index < thisVersion.length ? Integer.parseInt(thisVersion[index]) : 0;
            int otherVer = index < otherVersion.length ? Integer.parseInt(otherVersion[index]) : 0;
            
            if(ver < otherVer) return -1;
            if(ver > otherVer) return  1;
        }
        return 0;
    }

    /**
     * 
     * @param other
     *      The other version to be verified.
     * 
     * @return 
     *      {@code true} if the two version are equals.
     *      Otherwise, this method return {@code false}.
     */
    @Override
    public boolean equals(Object other) {
        
        if(this == other) return true;
        
        if(other == null) return false;
        
        if(this.getClass() != other.getClass()) return false;
        
        return this.compareTo((Version) other) == 0;
    }
}