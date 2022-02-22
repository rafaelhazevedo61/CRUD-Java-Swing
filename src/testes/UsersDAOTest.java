/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.UsersDAO;
import java.util.List;
import model.Users;

/**
 *
 * @author Rafael
 */
public class UsersDAOTest {

    public static void main(String[] args) {

//        selectDAOTest();
//        updateDAOTest();
//        insertDAOTest();
//        deleteDAOTest();
        verifyExistDAOTest();

    }

    public static void verifyExistDAOTest() {

        Users u = new Users();

        u.setUsername("admin");
        u.setPassword("admin");

        UsersDAO dao = new UsersDAO();

        boolean exist = dao.verifyExist(u);

        if (exist) {
            System.out.println("User authenticated");
        } else {
            System.out.println("User not authenticated");
        }

    }

    public static void deleteDAOTest() {

        int coduser = 0;

        UsersDAO dao = new UsersDAO();

        dao.deleteUser(coduser);

        System.out.println("User deleted with sucess!");

    }

    public static void insertDAOTest() {

        Users u = new Users();

        u.setUsername("admin2");
        u.setPassword("admin2");
        u.setName("admin2");
        u.setEmail("admin2@corporate.com");

        UsersDAO dao = new UsersDAO();

        dao.createUser(u);

        System.out.println("User inserted with sucess!");

    }

    public static void updateDAOTest() {

        Users u = new Users();

        u.setCoduser(1);
        u.setUsername("admin");
        u.setPassword("admin");
        u.setName("admin");
        u.setEmail("admin@corporate.com");

        UsersDAO dao = new UsersDAO();

        dao.updateUser(u);

        System.out.println("User updated with sucess!");

    }

    public static void selectDAOTest() {

        UsersDAO dao = new UsersDAO();

        List<Users> list = dao.readUsers();

        System.out.println(list);

    }

}
