
package com.example.demo.Apiresponse;


    public class ApiResponse<T> {
        private  String status;  // success / error
        private  String message;

//        public ApiResponse(){}
        public ApiResponse(String status,String message){
            this.status = status;
            this.message = message;
        }// description
             // actual payload


        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

