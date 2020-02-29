package me.anasmadrhar.githubstars.data.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static me.anasmadrhar.githubstars.data.remote.Status.ERROR;
import static me.anasmadrhar.githubstars.data.remote.Status.LOADING;
import static me.anasmadrhar.githubstars.data.remote.Status.SUCCESS;

/**
 * A generic class that holds a value with its loading status.
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public class Resource<T> {
    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    private final String message;

    private Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

    @Nullable
    public String getMessage() {
        return message;
    }
}
