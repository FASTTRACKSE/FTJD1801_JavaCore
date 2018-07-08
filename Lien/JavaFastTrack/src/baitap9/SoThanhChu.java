package baitap9;

import java.util.Scanner;

public class SoThanhChu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, dem=0 , quyDoi;
		String ketQua = "";
		 Scanner sc;
         System.out.println("Nhập n = ");
         sc = new Scanner(System.in);
         n = sc.nextInt();
         while(n>0) {
        	 quyDoi = n%10;
        	 n = n/10;
        	 dem+=1;
        	 if(quyDoi == 0) {
        		 if(dem==1) {
        			 ketQua = "" +ketQua;
        		 }
        		 else if(dem == 2) {
        			 ketQua = "lẻ" +ketQua;
        		 }
        		 else if(dem == 3) {
        			 ketQua = "không trăm" +ketQua;
        		 }
        		 else if(dem == 4) {
        			 ketQua = "" +ketQua;
        		 }
        	 }else if(quyDoi == 1) {
            		 if(dem==1) {
            			 ketQua = " một " +ketQua;
            		 }
            		 else if(dem == 2) {
            			 ketQua = " mười " +ketQua;
            		 }
            		 else if(dem == 3) {
            			 ketQua = "một trăm " +ketQua;
            		 }
            		 else if(dem == 4) {
            			 ketQua = " một nghìn " +ketQua;
            		 }
        	 } else if(quyDoi == 2) {
                		 if(dem==1) {
                			 ketQua = "hai " +ketQua;
                		 }
                		 else if(dem == 2) {
                			 ketQua = "hai mươi " +ketQua;
                		 }
                		 else if(dem == 3) {
                			 ketQua = "hai trăm " +ketQua;
                		 }
                		 else if(dem == 4) {
                			 ketQua = "hai nghìn " +ketQua;
                		 }
        	 } else if(quyDoi == 3) {
                    		 if(dem==1) {
                    			 ketQua = "ba " +ketQua;
                    		 }
                    		 else if(dem == 2) {
                    			 ketQua = "ba mươi " +ketQua;
                    		 }
                    		 else if(dem == 3) {
                    			 ketQua = "ba trăm " +ketQua;
                    		 }
                    		 else if(dem == 4) {
                    			 ketQua = "ba nghìn " +ketQua;
                    		 }
        	 }else if(quyDoi == 4) {
                        		 if(dem==1) {
                        			 ketQua = "bốn " +ketQua;
                        		 }
                        		 else if(dem == 2) {
                        			 ketQua = "bốn mươi " +ketQua;
                        		 }
                        		 else if(dem == 3) {
                        			 ketQua = "bốn trăm " +ketQua;
                        		 }
                        		 else if(dem == 4) {
                        			 ketQua = "bốn nghìn " +ketQua;
                        		 }
        	 }else if(quyDoi == 5) {
                            		 if(dem==1) {
                            			 ketQua = "năm " +ketQua;
                            		 }
                            		 else if(dem == 2) {
                            			 ketQua = "năm mươi " +ketQua;
                            		 }
                            		 else if(dem == 3) {
                            			 ketQua = "năm trăm " +ketQua;
                            		 }
                            		 else if(dem == 4) {
                            			 ketQua = "năm nghìn " +ketQua;
                            		 }
        	 }else if(quyDoi == 6) {
                                		 if(dem==1) {
                                			 ketQua = "sáu " +ketQua;
                                		 }
                                		 else if(dem == 2) {
                                			 ketQua = "sáu mươi " +ketQua;
                                		 }
                                		 else if(dem == 3) {
                                			 ketQua = "sáu trăm " +ketQua;
                                		 }
                                		 else if(dem == 4) {
                                			 ketQua = "sáu nghìn " +ketQua;
                                		 }
        	 }else if(quyDoi == 7) {
                                    		 if(dem==1) {
                                    			 ketQua = "bảy " +ketQua;
                                    		 }
                                    		 else if(dem == 2) {
                                    			 ketQua = "bảy mươi " +ketQua;
                                    		 }
                                    		 else if(dem == 3) {
                                    			 ketQua = "bảy trăm " +ketQua;
                                    		 }
                                    		 else if(dem == 4) {
                                    			 ketQua = "bảy nghìn " +ketQua;
                                    		 }
        	 } else if(quyDoi == 8) {
                                        		 if(dem==1) {
                                        			 ketQua = "tám " +ketQua;
                                        		 }
                                        		 else if(dem == 2) {
                                        			 ketQua = "tám mươi " +ketQua;
                                        		 }
                                        		 else if(dem == 3) {
                                        			 ketQua = "tám trăm " +ketQua;
                                        		 }
                                        		 else if(dem == 4) {
                                        			 ketQua = "tám nghìn " +ketQua;
                                        		 }
        	 } else if(quyDoi == 9) {
                                            		 if(dem==1) {
                                            			 ketQua = "chín " +ketQua;
                                            		 }
                                            		 else if(dem == 2) {
                                            			 ketQua = "chín mươi " +ketQua;
                                            		 }
                                            		 else if(dem == 3) {
                                            			 ketQua = "chín trăm " +ketQua;
                                            		 }
                                            		 else if(dem == 4) {
                                            			 ketQua = "chín nghìn" +ketQua;
                                            		 }
        	 }
         }
           System.out.println("kết quả: "+ketQua);                     		 

	}

   }
