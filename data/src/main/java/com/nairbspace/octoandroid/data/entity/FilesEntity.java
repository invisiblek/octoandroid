package com.nairbspace.octoandroid.data.entity;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.nairbspace.octoandroid.domain.model.AutoGson;

import java.util.List;

@AutoValue
@AutoGson(autoValueClass = AutoValue_FilesEntity.class)
public abstract class FilesEntity {
    @SerializedName("files") public abstract List<File> files();
    @SerializedName("free") public abstract Long free();
    @SerializedName("total") public abstract Long total();

    @AutoValue
    @AutoGson(autoValueClass = AutoValue_FilesEntity_File.class)
    public abstract static class File {
        @SerializedName("name") public abstract String name();
        @SerializedName("origin") public abstract String origin();
        @SerializedName("refs") public abstract Refs refs();
        @SerializedName("type") public abstract String type();
        @Nullable @SerializedName("size") public abstract Long size(); // In Bytes
        @Nullable @SerializedName("date") public abstract Long date(); // Unix
        @Nullable @SerializedName("gcodeAnalysis") public abstract GcodeAnalysis gcodeAnalysis();
        @Nullable @SerializedName("print") public abstract Print print();

        @AutoValue
        @AutoGson(autoValueClass = AutoValue_FilesEntity_File_Refs.class)
        public abstract static class Refs {
            @SerializedName("resource") public abstract String resource();
            @Nullable @SerializedName("download") public abstract String download();
        }

        @AutoValue
        @AutoGson(autoValueClass = AutoValue_FilesEntity_File_GcodeAnalysis.class)
        public abstract static class GcodeAnalysis {
            @Nullable @SerializedName("estimatedPrintTime") public abstract Double estimatedPrintTime();
            @Nullable @SerializedName("filament") public abstract Filament filament();

            @AutoValue
            @AutoGson(autoValueClass = AutoValue_FilesEntity_File_GcodeAnalysis_Filament.class)
            public abstract static class Filament {
                @Nullable @SerializedName("length") public abstract Double length();
                @Nullable @SerializedName("volume") public abstract Double volume();
            }
        }

        @AutoValue
        @AutoGson(autoValueClass = AutoValue_FilesEntity_File_Print.class)
        public abstract static class Print {
            @Nullable @SerializedName("failure") public abstract Long failure();
            @Nullable @SerializedName("success") public abstract Long success();
            @Nullable @SerializedName("last") public abstract Last last();

            @AutoValue
            @AutoGson(autoValueClass = AutoValue_FilesEntity_File_Print_Last.class)
            public abstract static class Last {
                @Nullable @SerializedName("date") public abstract Long date();
                @Nullable @SerializedName("success") public abstract Boolean success();

            }
        }
    }
}
