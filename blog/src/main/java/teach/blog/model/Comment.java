package teach.blog.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

public class Comment {

    @NotEmpty
    private String name;

    private Date date;

    @NotEmpty
    @Size(min = 20, max = 1024)
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        if (date != null ? !date.equals(comment1.date) : comment1.date != null) return false;
        if (name != null ? !name.equals(comment1.name) : comment1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
