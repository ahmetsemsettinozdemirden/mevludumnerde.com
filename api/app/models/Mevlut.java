package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.NotNull;
import io.ebean.annotation.UpdatedTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Mevlut extends Model{

    @Id
    public Long id;

    @NotEmpty
    public String name;

    @NotEmpty
    public String description;

    @NotNull
    @OneToOne
    public Position position;

    @UpdatedTimestamp
    @JsonIgnore
    public Date updatedAt;

    @CreatedTimestamp
    @JsonIgnore
    public Date createdAt;


    public static Finder<Long, Mevlut> find = new Finder<>(Mevlut.class);

}
