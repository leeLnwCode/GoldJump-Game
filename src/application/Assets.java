package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class Assets {
    private ArrayList<AssetType> characters = new ArrayList<>();
    private ArrayList<AssetType> backgrounds = new ArrayList<>();
    private ArrayList<AssetType> objects = new ArrayList<>();

    public Assets() {
        String currentDir = System.getProperty("user.dir");
//        System.out.print(Paths.get(currentDir, "src" , "application" , "pink_monster").toString());
        loadAssets(Paths.get(currentDir, "src" , "application" , "pink_monster"), "character", characters);
        loadAssets(Paths.get(currentDir, "src" , "application" , "Player_"), "character", characters);
        loadAssets(Paths.get(currentDir, "src" , "application" , "background"), "background", backgrounds);

        String[] subfolders = {"BG", "Object", "Tiles", "animetions"};
        for (String folder : subfolders) {
            loadAssets(Paths.get(currentDir, "src", "application", "objects", folder), "object", objects);
        }
    }

    private void loadAssets(Path path, String type, ArrayList<AssetType> list) {
        File directory = path.toFile();
        if (directory.isDirectory()) {
            for (String filename : directory.list()) {
                try {
                    FileInputStream loadImage = new FileInputStream(path.resolve(filename).toString());
                    Image image = new Image(loadImage);
                    AssetType data = new AssetType();
                    data.setType(type);
                    data.setName(filename);
                    data.setHeight(image.getHeight());
                    data.setWidth(image.getWidth());
                    data.setImage(image);
                    
                    if (type.equals("character") || type.equals("object")) {
                        for (double i = 1; i < 100; i++) {
                            if (image.getWidth() / i == image.getHeight()) {
                                data.setFrames((int) i);
                                break;
                            }
                        }
                    }
                    list.add(data);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Getters
    public AssetType GetCharsByName(String name) {
        return characters.stream().filter(e -> name.equals(e.getName())).findFirst().orElse(null);
    }

    public AssetType GetCharsByIndex(int index) {
        return characters.get(index);
    }

    public AssetType GetBackgroundByName(String name) {
        return backgrounds.stream().filter(e -> name.equals(e.getName())).findFirst().orElse(null);
    }

    public AssetType GetBackgroundByIndex(int index) {
        return backgrounds.get(index);
    }

    public AssetType GetObjectByName(String name) {
        return objects.stream().filter(e -> name.equals(e.getName())).findFirst().orElse(null);
    }

    public AssetType GetObjectByIndex(int index) {
        return objects.get(index);
    }
}