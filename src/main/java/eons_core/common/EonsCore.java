/** 
 * Project: Eons-Core
 * Started: 10/02/2020
 * Author: ArmouredHeart
 * Discord: ArmouredHeart#1208
 * GitHub: 
 * CurseForge: 
 * Licence: GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
 * Notice: Please refer to original source if you create any derived works.
 * I want to see what you can create!
 * Please enjoy this mod!
*/

// package
package main.java.eons_core.common;

// Forge imports


// Eons imports

// misc imports


/** */
@Mod(modid = EonsCore.MOD_ID, name = EonsCore.MOD_NAME, version = EonsCore.MOD_VERSION)
public class EonsCore {
    //
    public static final String MOD_ID = "eons_core";
    public static final String MOD_NAME = "Eons: Core";
    public static final String MOD_VERSION = "0.0.1";
    public static final String ACCEPTED_VERSION = "[1.14.4]";
    public static final String CLIENT_PROXY_CLASS = "";
    public static final String COMMON_PROXY_CLASS = "";

    //
    private static Logger logger;

    /** */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //
        logger = event.getModLog();
    }

    /** */
    @EventHandler
    public void preInit(FMLInitializationEvent event) {
        //
        
    }
}