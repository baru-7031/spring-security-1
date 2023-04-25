package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Configuration
public class SSLCertificationConfiguration {

    @Bean
    public static void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }




//    @Bean
//    public void registerKeyStore(String keyStoreName) {
//        try {
//            ClassLoader classLoader = this.getClass().getClassLoader();
//            InputStream keyStoreInputStream = classLoader.getResourceAsStream(keyStoreName);
//            if (keyStoreInputStream == null) {
//                throw new FileNotFoundException("Could not find file named '" + keyStoreName + "' in the CLASSPATH");
//            }
//
//            //load the keystore
//            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keystore.load(keyStoreInputStream, null);
//
//            //add to known keystore
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init(keystore);
//
//            //default SSL connections are initialized with the keystore above
//            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, trustManagers, null);
//            SSLContext.setDefault(sc);
//        } catch (IOException | GeneralSecurityException e) {
//            throw new RuntimeException(e);
//        }
//    }





//    private static final HostnameVerifier jvmHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
//
//    private static final HostnameVerifier trivialHostnameVerifier = new HostnameVerifier() {
//        public boolean verify(String hostname, SSLSession sslSession) {
//            return true;
//        }
//    };
//
//    private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER = new TrustManager[] { new X509TrustManager() {
//        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//            return null;
//        }
//
//        public void checkClientTrusted(X509Certificate[] certs, String authType) {
//        }
//
//        public void checkServerTrusted(X509Certificate[] certs, String authType) {
//        }
//    } };
//
//    public static void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException {
//        HttpsURLConnection.setDefaultHostnameVerifier(trivialHostnameVerifier);
//        // Install the all-trusting trust manager
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, UNQUESTIONING_TRUST_MANAGER, null);
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//    }
//
//    public static void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException {
//        HttpsURLConnection.setDefaultHostnameVerifier(jvmHostnameVerifier);
//        // Return it to the initial state (discovered by reflection, now hardcoded)
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, null, null);
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//    }


}
