package com.mint.qa.util;

import com.google.api.services.sheets.v4.SheetsScopes;
import org.mortbay.jetty.security.Credential;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleAuthorizeUtil {

    public static Credential credential;

    public static Credential authorize() throws IOException, GeneralSecurityException {

        // build GoogleClientSecrets from JSON file

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        return credential;
    }
}

