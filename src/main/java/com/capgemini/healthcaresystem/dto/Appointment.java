package com.capgemini.healthcaresystem.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;


public class Appointment {

        User user;
        BigInteger appointmentId;
        Test test;
        LocalDateTime datetime;
        boolean approved;
        
        // Constructor
        
        public Appointment(User user, BigInteger appointmentId, Test test, LocalDateTime datetime, boolean approved) {
                super();
                this.user = user;
                this.appointmentId = appointmentId;
                this.test = test;
                this.datetime = datetime;
                this.approved = approved;
        }
        
        // Getters and Setters
        
        public User getUser() {
                return user;
        }
        public void setUser(User user) {
                this.user = user;
        }
        public BigInteger getAppointmentId() {
                return appointmentId;
        }
        public void setAppointmentId(BigInteger appointmentId) {
                this.appointmentId = appointmentId;
        }
        public Test getTest() {
                return test;
        }
        public void setTest(Test test) {
                this.test = test;
        }
        public LocalDateTime getDatetime() {
                return datetime;
        }
        public void setDatetime(LocalDateTime datetime) {
                this.datetime = datetime;
        }
        public boolean isApproved() {
                return approved;
        }
        public void setApproved(boolean approved) {
                this.approved = approved;
        }
        
        
        
}