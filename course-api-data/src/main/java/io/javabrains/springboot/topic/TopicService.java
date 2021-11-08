 package io.javabrains.springboot.topic; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicrepository;
	
	private List<Topic> topics =new ArrayList<>(java.util.Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Framework Description"),
			new Topic("Java", "Java Framework", "Java Framework Description"),
			new Topic("Javascript", "Javascript Framework", "Javascript Framework Description")
			));
	public List<Topic>getAllTopics(){
		List<Topic>topics = new ArrayList<>();
		topicrepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	public Topic getTopic(String id) {
		 return topicrepository.findById(id).get();
	}
	public void addTopic(Topic topic) {
		topicrepository.save(topic);
	}
	public void updateTopic(String id, Topic topic) {
		topicrepository.save(topic);
	}
	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		topicrepository.deleteById(id);
	}
}
