package com.hodangsan.webbanhang.entity;

    public class User {
        private int iduser;
        private String userName;
        private String passWord;
        private String role;

        public User(int iduser, String userName, String passWord, String role) {
            this.iduser = iduser;
            this.userName = userName;
            this.passWord = passWord;
            this.role = role;
        }

        public int getIduser() {
            return iduser;
        }

        public void setIduser(int iduser) {
            this.iduser = iduser;
        }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
