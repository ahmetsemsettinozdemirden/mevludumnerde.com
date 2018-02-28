package controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class MevlutController extends Controller {

    public Result get() {

        //[{ position: {lat: 38.3292676, lng: 26.6414996} }]

        ArrayNode result = Json.newArray();
        ObjectNode mevlut = Json.newObject();
        mevlut.set("position", Json.newObject().put("lat", 38.3292676).put("lng", 26.6414996));
        result.add(mevlut);

        return ok(result);
    }

    public Result create() {
        return TODO;
    }

}
