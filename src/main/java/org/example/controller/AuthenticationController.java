package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.App;
import org.example.dao.DAO;
import org.example.exception.AuthenticationException;
import org.example.exception.login.LoginException;
import org.example.exception.registration.RegistrationException;
import org.example.model.User;
import org.example.model.UserPrivileges;
import org.example.security.AESEncryptionEngine;
import org.example.security.EncryptionPair;
import org.example.validator.RegistrationValidator;

import java.io.IOException;

public class AuthenticationController {

    private static final String authenticationRoot = "authentication";
    private static final String dashboardRoot = "dashboard";
    private static final String dashboardViewName = "dashboard";
    private static final String registerViewName = "register";
    private static final String loginViewName = "login";
    private static boolean isViewSetOnLogin = true;

    private DAO dao;
    private AESEncryptionEngine encryptionEngine;
    private RegistrationValidator registrationValidator;

    @FXML
    public TextField emailTextField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public PasswordField retypedPasswordField;

    @FXML
    public TextField firstNameTextField;

    @FXML
    public TextField lastNameTextField;

    @FXML
    public DatePicker birthDateDatePicker;

    @FXML
    public ComboBox<UserPrivileges> privilegesComboBox;

    @FXML
    public TextField phoneNumberField;


    public AuthenticationController() {
        this.dao = new DAO();
        this.encryptionEngine = new AESEncryptionEngine();
        this.registrationValidator = new RegistrationValidator();
    }

    @FXML
    public void handleSwitchAuthenticationViews(MouseEvent event) throws IOException {
        switchAuthenticationView();
    }

    public void switchAuthenticationView() throws IOException {
        loadLoginOrRegistrationView(isViewSetOnLogin);

        isViewSetOnLogin = !isViewSetOnLogin;
    }

    public void loadLoginOrRegistrationView(boolean isLoginView) throws IOException {
        if(isLoginView) {
            App.setRoot(authenticationRoot + "/" + registerViewName);
        }
        else {
            App.setRoot(authenticationRoot + "/" + loginViewName);
        }
    }

    @FXML
    public void doLogin(ActionEvent event) {
        try {
            tryToLogin();
        } catch (LoginException exception) {
            handleAuthenticationException(exception);
        }
    }

    public void tryToLogin() throws LoginException {
        dao.authenticateUser(
                emailTextField.getText(),
                encryptionEngine
                        .encrypt(getEncryptionPair(passwordField.getText()))
                        .toCharArray()
        );

        Alert successfulLoginAlert = new Alert(Alert.AlertType.CONFIRMATION);
        successfulLoginAlert.setTitle("Successful Login");
        successfulLoginAlert.setHeaderText("You successfully logged into your account!");
        successfulLoginAlert.setOnCloseRequest(dialogEvent -> {
            try {
                loadDashboardView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        successfulLoginAlert.show();
    }

    public void loadDashboardView() throws IOException {
        App.setRoot(dashboardRoot + "/" + dashboardViewName);
    }

    @FXML
    public void doRegister(ActionEvent event) {
        try {
            tryToRegister();
        } catch (RegistrationException e) {
            handleAuthenticationException(e);
        }
    }

    public void tryToRegister() throws RegistrationException {
        dao.createUser(buildUserForRegister());

        Alert successfulRegistrationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        successfulRegistrationAlert.setTitle("Successful Registration");
        successfulRegistrationAlert.setHeaderText("You successfully created your account!\nYou can login now into your account.");
        successfulRegistrationAlert.setOnCloseRequest(dialogEvent -> {
            try {
                switchAuthenticationView();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        successfulRegistrationAlert.show();
    }

    public User buildUserForRegister() throws RegistrationException {
        validateForRegistration();

        return new User.Builder(emailTextField.getText())
                .withFirstName(firstNameTextField.getText())
                .withLastName(lastNameTextField.getText())
                .withPhoneNumber(phoneNumberField.getText())
                .withDateOfBirth(birthDateDatePicker.getValue())
                .withPrivileges(privilegesComboBox.getSelectionModel().getSelectedItem())
                .withPassword(
                        encryptionEngine
                                .encrypt(getEncryptionPair(passwordField.getText()))
                                .toCharArray())
                .build();
    }

    public void validateForRegistration() throws RegistrationException {
        registrationValidator.validateName(firstNameTextField.getText());
        registrationValidator.validateName(lastNameTextField.getText());
        registrationValidator.validateEmail(emailTextField.getText());
        registrationValidator.validatePhoneNumber(phoneNumberField.getText());
        registrationValidator.validatePassword(passwordField.getText());
        registrationValidator.validatePasswordsMatching(passwordField.getText(), retypedPasswordField.getText());
    }

    public EncryptionPair getEncryptionPair(String text) {
        return new EncryptionPair.Builder("CourseManagementSystem").withText(text).build();
    }

    public void handleAuthenticationException(AuthenticationException e) {
        if(e != null) {
            Alert loginExceptionAlert = new Alert(Alert.AlertType.ERROR);
            loginExceptionAlert.setTitle(e.getTitle());
            loginExceptionAlert.setHeaderText(e.getMessage());
            loginExceptionAlert.show();
        }
    }
}
