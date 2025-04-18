import java.time.LocalDateTime;


public class Task {
    private static int generateId = 1;
    private int id;
    private String description;
    private String status = "todo";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updateAt = LocalDateTime.now();

    public Task(String description) {
        this.description = description;
        generateId++;
        setId(getGenerateId());
    }

    public static int getGenerateId() {
        return generateId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = --id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
