package com.example.fotomoto.Image;

import jakarta.persistence.*;

@Table(name = "image_model")

@Entity

public class ImageModel {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private Long id;
    private String name;
    private String type;


    @Column(length = 50000000)
    private byte[] picByte;


    public ImageModel(String name, String type, byte[] picByte) {
//        this.name = name;
//        this.type = type;
//        this.picByte = picByte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
    public ImageModel() {
        // Default constructor
    }

}
