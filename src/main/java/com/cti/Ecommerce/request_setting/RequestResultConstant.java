package com.cti.Ecommerce.request_setting;

public class RequestResultConstant {
    public static final int RESULT_CODE_ALL_IS_CORRECT = 200;

    public static final int RESULT_UNDEFINED_ERROR = 200;
    public static final String MESSAGE_UNDEFINED_ERROR = "Erreur du serveur";

    public static final int RESULT_CODE_EMAIL_EXIST = 201;
    public static final String MESSAGE_EMAIL_EXIST = "Cet email est déjà utilisé";

    public static final int RESULT_CODE_BAD_INFORMATION = 202;
    public static final String MESSAGE_BAD_INFORMATION = "Les informations fournies ne sont pas correctes";

    public static final int RESULT_CODE_BAD_CREDENTIALS = 203;
    public static final String MESSAGE_BAD_CREDENTIALS = "Your credentials are not correct";

    public static final int RESULT_CODE_USER_DONT_EXIST = 204;
    public static final String MESSAGE_USER_DONT_EXIST = "Ce compte n'existe pas";

    public static final int RESULT_CODE_USER_DELETED = 205;
    public static final String MESSAGE_USER_DELETED = "Ce compte a été supprimé";

    public static final int RESULT_CODE_USER_NOT_ACTIVATED = 206;
    public static final String MESSAGE_USER_NOT_ACTIVATED = "This account is not active";

    public static final int RESULT_CODE_OPERATION_NOT_ALLOWED = 207;
    public static final String MESSAGE_OPERATION_NOT_ALLOWED = "Opération non permise";

    public static final int RESULT_ACCESS_TOKEN_EXPIRED = 208;
    public static final String MESSAGE_ACCESS_TOKEN_EXPIRED = "Le token en cours d'utilisation a expiré";

    public static final int RESULT_CODE_EMAIL_NOT_SEND = 209;
    public static final String MESSAGE_EMAIL_NOT_SEND = "Email non envoyé";

    public static final int RESULT_CODE_USER_NOT_CONNECTED = 210;
    public static final String MESSAGE_USER_NOT_CONNECTED = "Utilisateur non connecté";

    public static final int RESULT_CODE_USER_ALREADY_ACTIVATED = 211;
    public static final String MESSAGE_USER_ALREADY_ACTIVATED = "Ce compte est déjà activé";

    public static final int RESULT_CODE_USER_ALREADY_DELETED = 212;
    public static final String MESSAGE_USER_ALREADY_DELETED = "Ce compte a déjà été supprimé";

    public static final int RESULT_CODE_USER_ASKED_ACTION_DONT_EXIST = 213;
    public static final String MESSAGE_USER_ASKED_ACTION_DONT_EXIST = "Le compte qui demande cette opération n'existe pas";

    public static final int RESULT_CODE_RESOURCE_NOT_FOUND = 214;
    public static final String MESSAGE_RESOURCE_NOT_FOUND = "Resource not found exception";

    public static final int RESULT_CODE_UNKNOWN_EXCEPTION = 215;

    public static final int RESULT_CODE_UNKNOWN_PASSWORD_TOKEN = 216;
    public static final String MESSAGE_UNKNOWN_PASSWORD_TOKEN = "Unknown password token";

    public static final int RESULT_CODE_UNKNOWN_USER_EMAIL = 217;
    public static final String MESSAGE_UNKNOWN_USER_EMAIL = "Unknown user email";

    public static final int RESULT_CODE_SUPER_ADMIN_ALREADY_EXIST = 218;
    public static final String MESSAGE_SUPER_ADMIN_ALREADY_EXIST = "Super administrator already exist on System";

    public static final int RESULT_CODE_UNKNOWN_EMAIL_TOKEN = 219;
    public static final String MESSAGE_UNKNOWN_EMAIL_TOKEN = "Unknown email verification token";

    public static final int RESULT_BAD_REQUEST_PARAMETER = 220;
    public static final String MESSAGE_BAD_REQUEST_PARAMETER = "some parameters provide are not correct";

    public static final int RESULT_CODE_SYSTEM_ALREADY_INIT = 221;
    public static final String MESSAGE_SYSTEM_ALREADY_INIT = "the systems is initialised, you can't create a super admin";

    public static final int RESULT_CODE_SYSTEM_INITIALISATION_FAILED = 222;
    public static final String MESSAGE_SYSTEM_INITIALISATION_FAILED = "the initialisation of the systems failed";

    public static final int RESULT_CODE_SYSTEM_NOT_INITIALISE_EXCEPTION = 223;
    public static final String MESSAGE_SYSTEM_NOT_INITIALISE = "The system is not initialise, please create the super admin to initialise it";

    public static final int RESULT_CODE_PAYPAL_PAYMENT_FAILED_EXCEPTION = 224;

    public static final int RESULT_CODE_SYSTEM_ALREADY_CONFIGURED = 225;
    public static final String MESSAGE_SYSTEM_ALREADY_CONFIGURED = "The systems is configured";


    public static final int RESULT_CODE_DOMAINE_EXIST = 226;
    public static final String MESSAGE_DOMAINE_EXIST = "Un domaine ayant ce nom existe déjà";

    public static final int RESULT_CODE_MEAL_CONSUMED = 227;
    public static final String MESSAGE_MEAL_CONSUMED = "Meal is already consumed";

    public static final int RESULT_CODE_INVALID_CALORIES = 228;
    public static final String MESSAGE_INVALID_CALORIES = "Calories cannot be below 1200 for Women and 1500 for Men";

    public static final int RESULT_CODE_INVALID_MACROS = 229;
    public static final String MESSAGE_INVALID_MACROS = "Total macros must equal the calorie count";

    public static final int RESULT_CODE_ACTIVE_STATE = 230;
    public static final String  MESSAGE_ACTIVE_STATE = "Status already active";

    public static final int RESULT_CODE_INACTIVE_STATE = 231;

    public static final String  MESSAGE_INACTIVE_STATE = "Status already inactive";

    public static final int RESULT_CODE_IMAGE_EXTENSION = 231;
    public static final String MESSAGE_IMAGE_EXTENSION = "Extension non prise en charge";

    public static final int RESULT_CODE_SCENE_NOT_EXIST = 232;
    public static final String MESSAGE_SCENE_NOT_EXIST = "Aucune scene disponible pour ce scenario";

    public static final int RESULT_CODE_ID_USER_TEST_NOT_EXIST = 233;
    public static final String MESSAGE_ID_USER_TEST_NOT_EXIST = " Id du test non renseigner";

    public static final int RESULT_CODE_ID_SCENARIO_NOT_EXIST = 234;
    public static final String MESSAGE_ID_SCENARIO_NOT_EXIST = " Id du scenario non renseigner";

    public static final int RESULT_CODE_INVALID_TOKEN = 235;
    public static final String MESSAGE_INVALID_TOKEN = "Invalid token";

    public static final int RESULT_CODE_ACTIVATION_TOKEN_EXPIRED = 236;
    public static final String MESSAGE_ACTIVATION_TOKEN_EXPIRED = "Activation token has expired. A new token has been sent to the same email address";

    public static final int RESULT_CODE_WRONG_PASSWORD = 237;
    public static final String MESSAGE_WRONG_PASSWORD = "Wrong password";

    public static final int RESULT_CODE_DIFFERENT_PASSWORD = 238;
    public static final String MESSAGE_DIFFERENT_PASSWORD = "Passwords are not the same";
}
