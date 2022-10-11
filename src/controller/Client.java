/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import model.User;
import view.GamePlayClientJFrame;
import view.GamePlayJFrame;
import view.HomePageFrm;
import view.LoginFrm;
import view.RegisterFrm;

/**
 *
 * @author FunG
 */
public class Client {
    public enum View{
        LOGIN,
        REGISTER,
        HOMEPAGE,
        GAMEPLAY,
        GAMEPLAYCLIENT
    }
    
    //Danh sach giao dien
    public static User user;
    public static RegisterFrm registerFrm;
    public static LoginFrm loginFrm;
    public static HomePageFrm homePageFrm;
    public static GamePlayJFrame gamePlayJFrame;
    public static GamePlayClientJFrame gamePlayClientJFrame;
    
    // Thiet lap socket
    public static SocketHandle socketHandle;

    public Client() {
    }
    
    public static JFrame getVisibleJFrame(){
        return  homePageFrm;
    }
    
    public void initView(){
        loginFrm = new LoginFrm();
        loginFrm.setVisible(true);
        socketHandle = new SocketHandle();
        socketHandle.run();
    }
    
    public static void openView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm = new LoginFrm();
                    loginFrm.setVisible(true);
                    break;
                case REGISTER:
                    registerFrm = new RegisterFrm();
                    registerFrm.setVisible(true);
                    break;
                case HOMEPAGE:
                    homePageFrm = new HomePageFrm();
                    homePageFrm.setVisible(true);
                    break;
                
                case GAMEPLAY:
                    gamePlayJFrame = new GamePlayJFrame();
                    gamePlayJFrame.setVisible(true);
                    break;
            }
        }
    }
    
    // mo giao dien gameplay voi nguoi choi khac
    public static void openView(View viewName, User competitor, int room_ID, int isStart, String competitorIP){
        if(viewName != null){
            switch(viewName){
                case GAMEPLAYCLIENT:
                    gamePlayClientJFrame = new GamePlayClientJFrame(competitor, room_ID, isStart, competitorIP);
                    gamePlayJFrame.setVisible(true);
                    break;
            }
        }
    }
    
    public static void closeView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm.dispose();
                    break;
                case REGISTER:
                    registerFrm.dispose();
                    break;
                case HOMEPAGE:
                    homePageFrm.dispose();
                    break;
                case GAMEPLAYCLIENT:
                    //gameClientFrm.stopAllThread();
                    gamePlayClientJFrame.dispose();
                    break;
            }
        }
    }
    
    public static void closeAllViews(){
        if(loginFrm!=null) loginFrm.dispose();
        if(registerFrm!=null) registerFrm.dispose();
        if(homePageFrm!=null) homePageFrm.dispose();

        if(gamePlayClientJFrame!=null){
            gamePlayClientJFrame.dispose();
        } 
        if(gamePlayJFrame!=null) gamePlayJFrame.dispose();
    }
    
    public static void main(String[] args) {
        new Client().initView();
    }
}
