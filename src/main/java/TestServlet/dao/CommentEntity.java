package TestServlet.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "db",name = "customer_comments")
public class CommentEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comment_line")
    private String commentLine;
    @Basic
    @Column(name ="comment_date")
    private String commentDate;
    @Column(name = "customer_id")
    private int IDCustomer;

    public int getId() {
        return id;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getCommentLine() {
        return commentLine;
    }

    public void setCommentLine(String commentLine) {
        this.commentLine = commentLine;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }


}
