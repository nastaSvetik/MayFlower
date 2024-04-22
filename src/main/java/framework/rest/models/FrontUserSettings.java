package framework.rest.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FrontUserSettings {
    private String name;
    private String value;

    public static FrontUserSettings getSettingsClickColumnOnly() {
        return FrontUserSettings.builder()
                .name("selectedColumnsSetting")
                .value("[\"clicks\"]")
                .build();
    }

}
