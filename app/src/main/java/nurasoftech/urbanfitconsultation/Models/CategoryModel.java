package nurasoftech.urbanfitconsultation.Models;

public class CategoryModel {
    public int image;
    public String categoryName;

    public CategoryModel(int image, String categoryName) {
        this.image = image;
        this.categoryName = categoryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
