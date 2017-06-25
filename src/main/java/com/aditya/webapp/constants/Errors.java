package com.aditya.webapp.constants;

public enum Errors {

    Exception(1011,"Exception"),
    AMAZONERROR(599,"Error in storing file"),
    CLOUDINARYERROR(598,"Error in uploading to cloudinary");

    private final int code;
    private final String description;

    private Errors(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }

}
