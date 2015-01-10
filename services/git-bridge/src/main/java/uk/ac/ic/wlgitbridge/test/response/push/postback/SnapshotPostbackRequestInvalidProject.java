package uk.ac.ic.wlgitbridge.test.response.push.postback;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.List;

/**
 * Created by Winston on 10/01/15.
 */
public class SnapshotPostbackRequestInvalidProject extends SnapshotPostbackRequest {

    private final List<String> errors;

    public SnapshotPostbackRequestInvalidProject(List<String> errors) {
        super("invalidProject");
        this.errors = errors;
    }

    @Override
    public JsonObject toJson() {
        JsonObject jsonThis = super.toJson();
        jsonThis.addProperty("message", "short string message for debugging");
        JsonArray jsonErrors = new JsonArray();
        for (String error : errors) {
            jsonErrors.add(new JsonPrimitive(error));
        }
        jsonThis.add("errors", jsonErrors);
        return jsonThis;
    }

}
