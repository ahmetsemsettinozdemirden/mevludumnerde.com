package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Mevlut;
import models.Position;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class MevlutController extends Controller {

    public Result getAll() {

        List<Mevlut> mevluts = Mevlut.find.all();

        return ok(Json.toJson(mevluts));
    }

    public Result get(Long id) {

        Mevlut mevlut = Mevlut.find.query().where().eq("id", id).findOne();

        if(mevlut == null)
            return notFound();

        return ok(Json.toJson(mevlut));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result create() {

        JsonNode body = request().body().asJson();

        Mevlut mevlut = new Mevlut();

        Position pos = new Position();
        pos.latitude = body.get("position").get("latitude").asDouble();
        pos.longitude = body.get("position").get("longitude").asDouble();
        pos.save();

        mevlut.name = body.get("name").asText();
        mevlut.description = body.get("description").asText();
        mevlut.position = pos;
        mevlut.save();

        return ok(Json.toJson(mevlut));
    }

    public Result update(Long id) {

        Mevlut mevlut = Mevlut.find.query().where().eq("id", id).findOne();

        if(mevlut == null)
            return notFound();

        JsonNode body = request().body().asJson();

        mevlut.name = body.get("name").asText();
        mevlut.description = body.get("description").asText();
        mevlut.position.latitude = body.get("position").get("latitude").asDouble();
        mevlut.position.longitude = body.get("position").get("longitude").asDouble();
        mevlut.save();

        return ok();
    }

    public Result delete(Long id) {

        Mevlut mevlut = Mevlut.find.query().where().eq("id", id).findOne();

        if(mevlut == null)
            return notFound();

        mevlut.delete();

        return ok();
    }

}
