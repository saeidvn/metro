package com.soldv.lesson7;

public class AudioObject extends CarObject {

    private String size;
    private Boolean disk;
    private Boolean usb;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getDisk() {
        return disk;
    }

    public void setDisk(Boolean disk) {
        this.disk = disk;
    }

    public Boolean getUsb() {
        return usb;
    }

    public void setUsb(Boolean usb) {
        this.usb = usb;
    }

}
