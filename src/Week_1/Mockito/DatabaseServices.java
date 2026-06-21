package Week_1.Mockito;

public class DatabaseServices {
}

interface Repository {
    String getData();
}

class Service {
    private final Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    public String processData() {
        return "Processed " + repo.getData();
    }
}

interface RestClient {
    String getResponse();
}

class ApiService {
    private final RestClient client;

    public ApiService(RestClient client) {
        this.client = client;
    }

    public String fetchData() {
        return "Fetched " + client.getResponse();
    }
}

interface FileReader {
    String read();
}

interface FileWriter {
    void write(String data);
}

class FileService {
    private final FileReader reader;
    private final FileWriter writer;

    public FileService(FileReader reader, FileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String processFile() {
        String content = reader.read();
        writer.write(content);
        return "Processed " + content;
    }
}

interface NetworkClient {
    String connect();
}

class NetworkService {
    private final NetworkClient client;

    public NetworkService(NetworkClient client) {
        this.client = client;
    }

    public String connectToServer() {
        return "Connected to " + client.connect();
    }
}
