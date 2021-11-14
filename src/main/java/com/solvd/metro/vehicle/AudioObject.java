package com.solvd.metro.vehicle;

public class AudioObject extends CarObject {

    private String size;
    private Boolean disk;
    private Boolean usb;
    private Model model;

    public enum Model {

        JVC("Jvc"), PIONEER("Pioneer"), SONY("Sony");

        private final String model;

        Model(String model) {
            this.model = model;
        }
        public String getModel() {
            return model;
        }

    }

    public AudioObject(Model model) {
        this.model = model;
    }

//    @Override
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

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
