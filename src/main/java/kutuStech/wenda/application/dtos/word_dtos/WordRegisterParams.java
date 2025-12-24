package kutuStech.wenda.application.dtos.word_dtos;

import java.util.List;

    // private String title;
    // private Boolean deleted;
    // private String description;
    // private String idCreator;
    // private List<Subpoint> subpoints;
    // private List<Reference> references;

public record WordRegisterParams(String idCreator,String title, String description,String idSuggestion ,List<String> points, List<String> references) {}
