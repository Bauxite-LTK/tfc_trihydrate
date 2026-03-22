package net.bauxite_ltk.tfc_trihydrate.util;

public enum Ores {
    HEMATITE("hematite"),
    LIMONITE("limonite"),
    MAGNETITE("magnetite"),
    NATIVE_COPPER("native_copper"),
    NATIVE_SILVER("native_silver"),
    NATIVE_GOLD("native_gold"),
    MALACHITE("malachite"),
    TETRAHEDRITE("tetrahedrite"),
    GARNIERITE("garnierite"),
    CASSITERITE("cassiterite"),
    SPHALERITE("sphalerite"),
    BISMUTHINITE("bismuthinite");


    private String name;
    private Ores(String name){
        this.name = name;
    }
}
