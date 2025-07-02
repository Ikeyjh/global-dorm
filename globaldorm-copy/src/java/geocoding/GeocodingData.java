package geocoding;

import java.util.List;

public class GeocodingData {

    private String status;
    private String match_type;
    private String input;
    private Data data;
    private List<String> copyright;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatch_type() {
        return match_type;
    }

    public void setMatch_type(String match_type) {
        this.match_type = match_type;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<String> getCopyright() {
        return copyright;
    }

    public void setCopyright(List<String> copyright) {
        this.copyright = copyright;
    }

    public static class Data {

        private String postcode;
        private String status;
        private String usertype;
        private long easting;
        private long northing;
        private long positional_quality_indicator;
        private String country;
        private String latitude;
        private String longitude;
        private String postcode_no_space;
        private String postcode_fixed_width_seven;
        private String postcode_fixed_width_eight;
        private String postcode_area;
        private String postcode_district;
        private String postcode_sector;
        private String outcode;
        private String incode;

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }

        public long getEasting() {
            return easting;
        }

        public void setEasting(long easting) {
            this.easting = easting;
        }

        public long getNorthing() {
            return northing;
        }

        public void setNorthing(long northing) {
            this.northing = northing;
        }

        public long getPositional_quality_indicator() {
            return positional_quality_indicator;
        }

        public void setPositional_quality_indicator(long positional_quality_indicator) {
            this.positional_quality_indicator = positional_quality_indicator;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getPostcode_no_space() {
            return postcode_no_space;
        }

        public void setPostcode_no_space(String postcode_no_space) {
            this.postcode_no_space = postcode_no_space;
        }

        public String getPostcode_fixed_width_seven() {
            return postcode_fixed_width_seven;
        }

        public void setPostcode_fixed_width_seven(String postcode_fixed_width_seven) {
            this.postcode_fixed_width_seven = postcode_fixed_width_seven;
        }

        public String getPostcode_fixed_width_eight() {
            return postcode_fixed_width_eight;
        }

        public void setPostcode_fixed_width_eight(String postcode_fixed_width_eight) {
            this.postcode_fixed_width_eight = postcode_fixed_width_eight;
        }

        public String getPostcode_area() {
            return postcode_area;
        }

        public void setPostcode_area(String postcode_area) {
            this.postcode_area = postcode_area;
        }

        public String getPostcode_district() {
            return postcode_district;
        }

        public void setPostcode_district(String postcode_district) {
            this.postcode_district = postcode_district;
        }

        public String getPostcode_sector() {
            return postcode_sector;
        }

        public void setPostcode_sector(String postcode_sector) {
            this.postcode_sector = postcode_sector;
        }

        public String getOutcode() {
            return outcode;
        }

        public void setOutcode(String outcode) {
            this.outcode = outcode;
        }

        public String getIncode() {
            return incode;
        }

        public void setIncode(String incode) {
            this.incode = incode;
        }
    }
}
