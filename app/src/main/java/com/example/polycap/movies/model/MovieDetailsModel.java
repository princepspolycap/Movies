package com.example.polycap.movies.model;

import com.example.polycap.movies.view.EntertainmentApp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Polycap on 2/6/2016.
 */
public class MovieDetailsModel {

    public static Observable <MovieDetailsModel> requestMovieDetails (String mId){
        MovieDetailsClient movieDetailsClient = new MovieDetailsClient ((EntertainmentApp)EntertainmentApp.getContext());
        return movieDetailsClient.getMovieDResults(mId);

    }

        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("belongs_to_collection")
        @Expose
        private Object belongsToCollection;
        @SerializedName("budget")
        @Expose
        private Integer budget;
        @SerializedName("genres")
        @Expose
        private List<Genre> genres = new ArrayList<Genre>();
        @SerializedName("homepage")
        @Expose
        private String homepage;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("imdb_id")
        @Expose
        private String imdbId;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("popularity")
        @Expose
        private Float popularity;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("production_companies")
        @Expose
        private List<ProductionCompany> productionCompanies = new ArrayList<ProductionCompany>();
        @SerializedName("production_countries")
        @Expose
        private List<ProductionCountry> productionCountries = new ArrayList<ProductionCountry>();
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("revenue")
        @Expose
        private Integer revenue;
        @SerializedName("runtime")
        @Expose
        private Integer runtime;
        @SerializedName("spoken_languages")
        @Expose
        private List<SpokenLanguage> spokenLanguages = new ArrayList<SpokenLanguage>();
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("tagline")
        @Expose
        private String tagline;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("video")
        @Expose
        private Boolean video;
        @SerializedName("vote_average")
        @Expose
        private Float voteAverage;
        @SerializedName("vote_count")
        @Expose
        private Integer voteCount;

        /**
         * @return The adult
         */
        public Boolean getAdult() {
            return adult;
        }

        /**
         * @param adult The adult
         */
        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        /**
         * @return The backdropPath
         */
        public String getBackdropPath() {
            return backdropPath;
        }

        /**
         * @param backdropPath The backdrop_path
         */
        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        /**
         * @return The belongsToCollection
         */
        public Object getBelongsToCollection() {
            return belongsToCollection;
        }

        /**
         * @param belongsToCollection The belongs_to_collection
         */
        public void setBelongsToCollection(Object belongsToCollection) {
            this.belongsToCollection = belongsToCollection;
        }

        /**
         * @return The budget
         */
        public Integer getBudget() {
            return budget;
        }

        /**
         * @param budget The budget
         */
        public void setBudget(Integer budget) {
            this.budget = budget;
        }

        /**
         * @return The genres
         */
        public List<Genre> getGenres() {
            return genres;
        }

        /**
         * @param genres The genres
         */
        public void setGenres(List<Genre> genres) {
            this.genres = genres;
        }

        /**
         * @return The homepage
         */
        public String getHomepage() {
            return homepage;
        }

        /**
         * @param homepage The homepage
         */
        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

        /**
         * @return The id
         */
        public Integer getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * @return The imdbId
         */
        public String getImdbId() {
            return imdbId;
        }

        /**
         * @param imdbId The imdb_id
         */
        public void setImdbId(String imdbId) {
            this.imdbId = imdbId;
        }

        /**
         * @return The originalLanguage
         */
        public String getOriginalLanguage() {
            return originalLanguage;
        }

        /**
         * @param originalLanguage The original_language
         */
        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        /**
         * @return The originalTitle
         */
        public String getOriginalTitle() {
            return originalTitle;
        }

        /**
         * @param originalTitle The original_title
         */
        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        /**
         * @return The overview
         */
        public String getOverview() {
            return overview;
        }

        /**
         * @param overview The overview
         */
        public void setOverview(String overview) {
            this.overview = overview;
        }

        /**
         * @return The popularity
         */
        public Float getPopularity() {
            return popularity;
        }

        /**
         * @param popularity The popularity
         */
        public void setPopularity(Float popularity) {
            this.popularity = popularity;
        }

        /**
         * @return The posterPath
         */
        public String getPosterPath() {
            return posterPath;
        }

        /**
         * @param posterPath The poster_path
         */
        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        /**
         * @return The productionCompanies
         */
        public List<ProductionCompany> getProductionCompanies() {
            return productionCompanies;
        }

        /**
         * @param productionCompanies The production_companies
         */
        public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
            this.productionCompanies = productionCompanies;
        }

        /**
         * @return The productionCountries
         */
        public List<ProductionCountry> getProductionCountries() {
            return productionCountries;
        }

        /**
         * @param productionCountries The production_countries
         */
        public void setProductionCountries(List<ProductionCountry> productionCountries) {
            this.productionCountries = productionCountries;
        }

        /**
         * @return The releaseDate
         */
        public String getReleaseDate() {
            return releaseDate;
        }

        /**
         * @param releaseDate The release_date
         */
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        /**
         * @return The revenue
         */
        public Integer getRevenue() {
            return revenue;
        }

        /**
         * @param revenue The revenue
         */
        public void setRevenue(Integer revenue) {
            this.revenue = revenue;
        }

        /**
         * @return The runtime
         */
        public Integer getRuntime() {
            return runtime;
        }

        /**
         * @param runtime The runtime
         */
        public void setRuntime(Integer runtime) {
            this.runtime = runtime;
        }

        /**
         * @return The spokenLanguages
         */
        public List<SpokenLanguage> getSpokenLanguages() {
            return spokenLanguages;
        }

        /**
         * @param spokenLanguages The spoken_languages
         */
        public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
            this.spokenLanguages = spokenLanguages;
        }

        /**
         * @return The status
         */
        public String getStatus() {
            return status;
        }

        /**
         * @param status The status
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         * @return The tagline
         */
        public String getTagline() {
            return tagline;
        }

        /**
         * @param tagline The tagline
         */
        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The video
         */
        public Boolean getVideo() {
            return video;
        }

        /**
         * @param video The video
         */
        public void setVideo(Boolean video) {
            this.video = video;
        }

        /**
         * @return The voteAverage
         */
        public Float getVoteAverage() {
            return voteAverage;
        }

        /**
         * @param voteAverage The vote_average
         */
        public void setVoteAverage(Float voteAverage) {
            this.voteAverage = voteAverage;
        }

        /**
         * @return The voteCount
         */
        public Integer getVoteCount() {
            return voteCount;
        }

        /**
         * @param voteCount The vote_count
         */
        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

    }

//    class Genre {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("name")
//        @Expose
//        private String name;
//
//        /**
//         * @return The id
//         */
//        public Integer getId() {
//            return id;
//        }
//
//        /**
//         * @param id The id
//         */
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        /**
//         * @return The name
//         */
//        public String getName() {
//            return name;
//        }
//
//        /**
//         * @param name The name
//         */
//        public void setName(String name) {
//            this.name = name;
//        }
//
//    }
//
//    class ProductionCompany {
//
//        @SerializedName("name")
//        @Expose
//        private String name;
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//
//        /**
//         * @return The name
//         */
//        public String getName() {
//            return name;
//        }
//
//        /**
//         * @param name The name
//         */
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        /**
//         * @return The id
//         */
//        public Integer getId() {
//            return id;
//        }
//
//        /**
//         * @param id The id
//         */
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//    }

    class ProductionCountry {

        @SerializedName("iso_3166_1")
        @Expose
        private String iso31661;
        @SerializedName("name")
        @Expose
        private String name;

        /**
         * @return The iso31661
         */
        public String getIso31661() {
            return iso31661;
        }

        /**
         * @param iso31661 The iso_3166_1
         */
        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

    }


    class SpokenLanguage {

        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @SerializedName("name")
        @Expose
        private String name;

        /**
         * @return The iso6391
         */
        public String getIso6391() {
            return iso6391;
        }

        /**
         * @param iso6391 The iso_639_1
         */
        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

    }
