/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import model.Users;

/**
 *
 * @author Rafael
 */
public class UsersTest {
    
    public static void main(String[] args) {

        usersModelTest();
        
    }
    
    public static void usersModelTest(){
        
        Users u1 = new Users();
        
        u1.setCoduser(1);
        u1.setUsername("admin");
        u1.setPassword("admin");
        u1.setName("admin");
        u1.setEmail("admin@corporate.com");
        
        System.out.println(u1);
        
        
    }  
      
}
