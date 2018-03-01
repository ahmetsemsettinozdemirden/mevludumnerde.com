package models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.NotNull;
import io.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Position extends Model{

    @Id
    @JsonIgnore
    public Long id;

    @NotNull
    public Double latitude;

    @NotNull
    public Double longitude;

    @UpdatedTimestamp
    @JsonIgnore
    public Date updatedAt;

    @CreatedTimestamp
    @JsonIgnore
    public Date createdAt;

    public static Finder<Long, Position> find = new Finder<>(Position.class);

}
