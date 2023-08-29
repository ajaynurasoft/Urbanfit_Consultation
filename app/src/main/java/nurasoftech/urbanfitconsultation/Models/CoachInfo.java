package nurasoftech.urbanfitconsultation.Models;

public class CoachInfo {
    public int image;
    public String name;
    public String rating;
    public String hashtag1;
    public String hashtag2;
    public String skills;
    public String price;

    public CoachInfo(int image, String name, String rating, String hashtag1, String hashtag2, String skills, String price) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.hashtag1 = hashtag1;
        this.hashtag2 = hashtag2;
        this.skills = skills;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getHashtag1() {
        return hashtag1;
    }

    public void setHashtag1(String hashtag1) {
        this.hashtag1 = hashtag1;
    }

    public String getHashtag2() {
        return hashtag2;
    }

    public void setHashtag2(String hashtag2) {
        this.hashtag2 = hashtag2;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
