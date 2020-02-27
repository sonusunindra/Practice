package com.sonu;

/**************************************************************************************************/
/*
 *
 * DO NOT ADD PACKAGE DECLARATION
 * PLEASE NOTE: THIS SKELETON FILE MUST BE PLACED UNDER DEFAULT PACKAGE OF SRC FOLDER
 *
 * ALL THE CODING MUST BE DONE INSIDE THIS SINGLE .JAVA FILE ONLY
 * DO NOT CREATE DEPENDENT CLASSES
 * DO NOT MODIFY CODE SKELETON
 * DO NOT MODIFY:
 * 		ACCESS SPECIFIERS, RETURN TYPES OR DATA TYPES, EXCEPTION CLAUSES,
 * 	    CLASS OR METHOD NAMES IN THE SKELETON
 *
 *
 *  YOU MUST CODE ON THE SAME PROJECT MAPPED IN EBOX VIEW THROUGHOUT THE ASSESSMENT
 *  CLICK ON 'Problem/Project Status' BUTTON TO SEE THE PROJECT MAPPED IN EBOX
 *
 *  YOU MUST CLICK ON 'SAVE PROJECT' BUTTON EVERY 10 MINUTES TO PERIODICALLY SAVE
 *  CTRL + S ALONE, WILL NOT BE SUFFICIENT TO SAVE YOUR CODE IN EBOX
 *  CLICKING ON 'SAVE PROJECT' ENSURES NO LOSS OF CODE
 *
 *  REACH OUT TO PROCTORS FOR ANY QUERIES
 *
 * Skeleton Version 2.0
 * Date Modified: 21-June-2016
 */
/*************************************************************************************************/

// imports here

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class must be used to write the solution for the given requirement. No
 * additional classes must be created.
 *
 */
public class PatientInformationTool {

    /**
     * @param args
     * @throws PatientInformationDetailsException
     */
    public static void main(String[] args) {

        // Change this to the absolute path where you have placed the input feed
        String filePath = "C:\\Users\\416289\\Desktop\\Skeleton\\input.txt";
        //File file = new File(filePath);
        Map<Integer, Map> patientMap = new HashMap<Integer, Map>();
        PatientInformationTool informationTool = new PatientInformationTool();
        try {
            patientMap = informationTool.getPatientDetails(filePath);
        } catch (PatientInformationDetailsException e) {
            e.printStackTrace();
        }

        System.out.println(patientMap);

        /*
         * Run the following code snippet to validate your code structure before
         * uploading the code. Do not edit this code.
         */


    }

    /**
     * @param filePath
     * @return Map<Integer, Map>
     * @throws PatientInformationDetailsException
     */
    public Map<Integer, Map> getPatientDetails(final String filePath)
            throws PatientInformationDetailsException {

        // TODO Associate to type their code here
        // TODO Associate to modify the return statement according to the
        // requirement
        String patientInfo = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        PatientVO patientVO = null;
        ArrayList<PatientVO> patientList = new ArrayList<PatientVO>();
        Map<String, List<PatientVO>> map1 = new HashMap<String, List<PatientVO>>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        Map<Integer, Map> finalMap = new HashMap<Integer, Map>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((patientInfo = reader.readLine()) != null){
                String[] patient = patientInfo.split(";");
                validateFields(patient);
                if(patient != null && patient.length > 0){
                    int i = 0;
                    patientVO = new PatientVO();
                    patientVO.setName(patient[i++]);
                    patientVO.setMrn(patient[i++]);
                    patientVO.setGender(patient[i++]);
                    patientVO.setPhysicianId(patient[i++]);
                    patientVO.setAdmissionDate(format.parse(patient[i++]));
                    patientVO.setDischargeDate(format.parse(patient[i++]));
                    patientVO.setBill(calculateBill(patientVO));
                    patientList.add(patientVO);
                } else {
                    throw new PatientInformationDetailsException("Patient List is empty");
                }
            }
            if(!patientList.isEmpty()) {
                System.out.println(patientList);
                map1 = patientDetails(patientList);
                map2 = physicianDetails(patientList);
            }

            finalMap.put(1, map1);
            finalMap.put(2, map2);

        } catch (FileNotFoundException e) {
            throw new PatientInformationDetailsException("Patient list File not found");
        } catch (IOException e) {
            throw new PatientInformationDetailsException("Patient list File found, But has no values");
        } catch (ParseException e) {
            throw new PatientInformationDetailsException("Error Parsing Patient Admission/Discharge Date");
        }

        return finalMap; // TODO Change this return value

    }

    private void validateFields(String[] patient) throws PatientInformationDetailsException {
        if(patient!=null && (patient[0].isEmpty()|| patient[1].isEmpty()|| patient[2].isEmpty() || patient[3].isEmpty()|| patient[4].isEmpty()|| patient[5].isEmpty())){
            throw new PatientInformationDetailsException("All Fields are Mandatory");
        } else {
            if (patient[1].startsWith("IN") || patient[1].startsWith("OUT")) {
                if (patient[1].startsWith("IN")) {
                    char[] in = patient[1].toCharArray();
                    for (int i = 2; i < in.length; i++) {
                        if (!Character.isDigit(in[i])) {
                            throw new PatientInformationDetailsException(
                                    "remaining digits can only be digits");
                        }
                    }
                }
                if (patient[1].startsWith("OUT")) {
                    char[] out = patient[1].toCharArray();
                    for (int i = 3; i < out.length; i++) {
                        if (!Character.isDigit(out[i])) {
                            throw new PatientInformationDetailsException(
                                    "remaining digits can only be digits");
                        }
                    }
                }
            } else {
                throw new PatientInformationDetailsException(
                        "MRN can start with IN or OUT");
            }
            String[] physicianID = patient[3].split("-");
            char[] p = physicianID[0].toCharArray();
            for (int i = 0; i < p.length; i++) {
                if (!Character.isDigit(p[i])) {
                    throw new PatientInformationDetailsException(
                            "first four words of physician Id can be digits only");
                }
            }
            if (p.length > 4) {
                throw new PatientInformationDetailsException(
                        "physician Id length cannot be greater than 4");
            }
        }
    }

    private int calculateBill(PatientVO patientVO) throws PatientInformationDetailsException {
        int bill = 0;
        int count = 0 ;
        if(patientVO != null){
            count = validateDate(patientVO);
            String phyvalue = patientVO.getPhysicianId();
            String[] phy = phyvalue.split("-");
            //String phyId = phy[0];
            String phyCtgry = phy[1];
            if("GEN".equalsIgnoreCase(phyCtgry)){
                bill = count * 1250;
            } else if("ENT".equalsIgnoreCase(phyCtgry)){
                bill = count * 1500;
            } else if("NEU".equalsIgnoreCase(phyCtgry)){
                bill = count * 1750;
            } else {
                throw new PatientInformationDetailsException("Patient category no found");
            }
        }
        return bill;
    }

    private int validateDate(PatientVO patientVO) throws PatientInformationDetailsException {
        Date admitDate = patientVO.getAdmissionDate();
        Date disDate = patientVO.getDischargeDate();
        int count = 0;
        if(admitDate.compareTo(disDate) > 0) {
            throw new PatientInformationDetailsException("Admission date is greater than Discharge date");
        } else {
            count = disDate.getDate() - admitDate.getDate();
            if(count < 0) {
                count = count + 30;
            }
        }
        return count;
    }

    private Map<String, List<PatientVO>> patientDetails(ArrayList<PatientVO> list){
        HashSet set = new HashSet();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Map<String, List<PatientVO>> map = new HashMap<String, List<PatientVO>>();
        ArrayList<String> list1 = new ArrayList<String>();
        for(PatientVO patientVO : list){
            set.add(date.format(patientVO.getAdmissionDate()).toString());
        }
        list1.addAll(set);

        for(String key : list1){
            ArrayList<PatientVO> temp = new ArrayList<PatientVO>();
            for(PatientVO patientVO : list) {
                if(key.equalsIgnoreCase(date.format(patientVO.getAdmissionDate()).toString())) {
                    temp.add(patientVO);
                }
            }
            map.put(key, temp);
        }
        return map;
    }

    private Map<String, Integer> physicianDetails(
            ArrayList<PatientVO> list) {
        HashSet set = new HashSet();
        Map<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<String> list1 = new ArrayList<String>();
        for(PatientVO patientVO : list){
            String phyvalue = patientVO.getPhysicianId();
            String[] phy = phyvalue.split("-");
            String phyCtgry = phy[1];
            set.add(phyCtgry);
        }
        list1.addAll(set);

        for(String key : list1){
            int count = 0;
            for(PatientVO patientVO : list) {
                String phyvalue = patientVO.getPhysicianId();
                String[] phy = phyvalue.split("-");
                String phyCtgry = phy[1];
                if(phyCtgry.equalsIgnoreCase(key)){
                    count++;
                }
            }
            map.put(key, count);
        }

        return map;
    }
}


/**
 * VO class supplied part of the Skeleton. Do not modify this class
 *
 */
class PatientVO {
    private String name;
    private String mrn;
    private String gender;
    private String physicianId;
    private Date admissionDate;
    private Date dischargeDate;
    private int bill;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mrn
     */
    public String getMrn() {
        return mrn;
    }

    /**
     * @param mrn the mrn to set
     */
    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the physicianId
     */
    public String getPhysicianId() {
        return physicianId;
    }

    /**
     * @param physicianId the physicianId to set
     */
    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    /**
     * @return the admissionDate
     */
    public Date getAdmissionDate() {
        return admissionDate;
    }

    /**
     * @param admissionDate the admissionDate to set
     */
    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * @return the dischargeDate
     */
    public Date getDischargeDate() {
        return dischargeDate;
    }

    /**
     * @param dischargeDate the dischargeDate to set
     */
    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    /**
     * @return the bill
     */
    public int getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(int bill) {
        this.bill = bill;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PatientVO [name=");
        builder.append(name);
        builder.append(", mrn=");
        builder.append(mrn);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", physicianId=");
        builder.append(physicianId);
        builder.append(", admissionDate=");
        builder.append(admissionDate);
        builder.append(", dischargeDate=");
        builder.append(dischargeDate);
        builder.append(", bill=");
        builder.append(bill);
        builder.append("]");
        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;
        PatientVO other = (PatientVO) object;
        if ((this.getMrn().equals(other.getMrn()))
                && (this.getPhysicianId().equals(other.getPhysicianId()))
                && (this.getAdmissionDate().equals(other.getAdmissionDate()))
                && (this.getBill() == other.getBill())
                && (this.getDischargeDate().equals(other.getDischargeDate()))) {
            isEqual = true;
        }
        return isEqual;
    }

}
/**
 *
 * Exception class supplied part of the Skeleton. Do not modify this class
 *
 */
class PatientInformationDetailsException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -217307602928815575L;

    public PatientInformationDetailsException(String message) {
        super(message);
    }

    public PatientInformationDetailsException(Throwable throwable) {
        super(throwable);
    }

    public PatientInformationDetailsException(String message,
                                              Throwable throwable) {
        super(message, throwable);
    }
}

