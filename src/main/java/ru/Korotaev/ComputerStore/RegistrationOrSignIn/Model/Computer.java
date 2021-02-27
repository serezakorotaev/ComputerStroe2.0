package ru.Korotaev.ComputerStore.RegistrationOrSignIn.Model;

import java.util.Objects;
/***
 *
 * @version 15.0.01
 * @autor Sergey Korotaev
 *
 * This class is model for create Computer objects. This class is used in classes
 * where user makes a purchase a computers. In classes computers to find by id. This model has
 * constructor with id which determines which computer it is and using his information
 */
public class Computer {
    /**
     *Field id at computer
     */
    private int id;
    /**
     *Field name at computer
     */
    private String name;
    /**
     * Field name main plate in computer
     */
    private String maneplate;
    /**
     * Field name power unit in computer
     */
    private String powerunit;
    /**
     * Field name processor in computer
     */
    private String processor;
    /**
     * Field name rammemory in computer
     */
    private String rammemory;
    /**
     * Field name videocard in computer
     */
    private String videocard;
    /**
     * Field count this computers
     */
    private int count;

    /**
     * Constructor for create new Computer object
     */
    public Computer() {
    }

    /**
     *
     * @param id
     * Constructor for create new object by id
     */
    public Computer(int id){
        this.id = id;
    }

    /**
     *
     * @return id at computer object
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id by computer object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name by computer object
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name by computer object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return name main plate at computer object
     */
    public String getManeplate() {
        return maneplate;
    }

    /**
     *
     * @param maneplate name main plate by computer object
     */
    public void setManeplate(String maneplate) {
        this.maneplate = maneplate;
    }

    /**
     *
     * @return name power unit at computer
     */
    public String getPowerunit() {
        return powerunit;
    }

    /**
     *
     * @param powerunit it is name power unit in computer object
     */
    public void setPowerunit(String powerunit) {
        this.powerunit = powerunit;
    }

    /**
     *
     * @return name processor in computer object
     */
    public String getProcessor() {
        return processor;
    }

    /**
     *
     * @param processor it is name processor in computer object
     */
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    /**
     *
     * @return name RAM Memory in computer object
     */
    public String getRammemory() {
        return rammemory;
    }

    /**
     *
     * @param rammemory it is name RAM Memory in computer
     */
    public void setRammemory(String rammemory) {
        this.rammemory = rammemory;
    }

    /**
     *
     * @return name video card in computer object
     */
    public String getVideocard() {
        return videocard;
    }

    /**
     *
     * @param videocard it is name video card in computer object
     */
    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    /**
     *
     * @return count How many computers in warehouse
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count it is value how many computers in warehouse
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @param o this other computer object
     * @return true or false by comparison elements
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return id == computer.id && count == computer.count && name.equals(computer.name) && maneplate.equals(computer.maneplate) && powerunit.equals(computer.powerunit) && processor.equals(computer.processor) && rammemory.equals(computer.rammemory) && videocard.equals(computer.videocard);
    }

    /**
     *
     * @return hashCode at computer object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, maneplate, powerunit, processor, rammemory, videocard, count);
    }

    /**
     *
     * @return String about information with fields computer class
     */
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
