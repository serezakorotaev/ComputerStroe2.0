package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model;

import java.util.Objects;

public class Computer {
    private int id;
    private String name;

    private String maneplate;
    private String powerunit;
    private String processor;
    private String rammemory;
    private String videocard;

    private int count;

    public Computer() {
    }
    public Computer(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManeplate() {
        return maneplate;
    }

    public void setManeplate(String maneplate) {
        this.maneplate = maneplate;
    }

    public String getPowerunit() {
        return powerunit;
    }

    public void setPowerunit(String powerunit) {
        this.powerunit = powerunit;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRammemory() {
        return rammemory;
    }

    public void setRammemory(String rammemory) {
        this.rammemory = rammemory;
    }

    public String getVideocard() {
        return videocard;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return id == computer.id && count == computer.count && name.equals(computer.name) && maneplate.equals(computer.maneplate) && powerunit.equals(computer.powerunit) && processor.equals(computer.processor) && rammemory.equals(computer.rammemory) && videocard.equals(computer.videocard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maneplate, powerunit, processor, rammemory, videocard, count);
    }

    @Override
    public String toString() {
        return name + System.lineSeparator() +
                "specification:" + System.lineSeparator()+
                "Mane plate: " + maneplate + System.lineSeparator() +
                "Power unit: " + powerunit + System.lineSeparator() +
                "Processor: " + processor + System.lineSeparator()+
                "Rammemory: " + rammemory + System.lineSeparator() +
                "Videocard: " + videocard + System.lineSeparator();
    }

}
