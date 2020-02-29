package me.anasmadrhar.githubstars.data.remote;

/**
 * Keep all the service related constants here.
 * Author: Anas Madrhar
 * Email: webmasterdisco4@gmail.com
 */
public class ApiConstants {
    public static final String BASE_URL = "https://api.github.com/";
    public static final long CONNECT_TIMEOUT = 30000;
    public static final long READ_TIMEOUT = 30000;
    public static final long WRITE_TIMEOUT = 30000;
    public static final int PER_PAGE = 10;

    private ApiConstants() {
        // Private constructor to hide the implicit one
    }
}
