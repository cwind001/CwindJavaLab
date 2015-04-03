package com.cwind.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class GroupAndSubGroupTest {
	public static void main(String[] args){
		ObjectMapper mapper = new ObjectMapper();
		mapper = new ObjectMapper();
		mapper.enableDefaultTyping();
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(
				DeserializationConfig.Feature.AUTO_DETECT_CREATORS, true);
		mapper.getSerializationConfig().enable(SerializationConfig.Feature.INDENT_OUTPUT);
		IGroup homeGroup = new IGroup("HOME");
		IGroup sub1 = new IGroup("sub1");
		IGroup sub2 = new IGroup("sub2");
		IGroup grandson1 = new IGroup("grandSon1");
		IGroup grandson2 = new IGroup("grandSon2");
		IGroup grandson3 = new IGroup("grandSon3");
		IGroup grandson4 = new IGroup("grandSon4");
		homeGroup.getSubGroups().add(sub1);
		homeGroup.getSubGroups().add(sub2);
		sub1.getSubGroups().add(grandson1);
		sub1.getSubGroups().add(grandson2);
		sub2.getSubGroups().add(grandson3);
		sub2.getSubGroups().add(grandson4);
		String[] groupNamesToBeRemoved={"grandSon4", "grandSon1"};
		for(String groupName : groupNamesToBeRemoved){
			System.out.println("***Group Name: "+groupName);
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
		IGroup hg1;
		if(true){
			hg1 = new IGroup("hg1111");
		}
		System.out.println(hg1.getName());
		
		try {
			GroupAndSubGroupTest mainObj = new GroupAndSubGroupTest();
			mainObj.removeChildGroups(homeGroup, groupNamesToBeRemoved);
			
			mapper.writeValue(System.out, homeGroup);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void removeChildGroups(IGroup group, String[] groupNames){
		BlockingQueue<IGroup> queue = new LinkedBlockingQueue<IGroup>();
		List<IGroup> subGroups = group.getSubGroups();
		removeChildGroupsFromList(subGroups, groupNames, queue);
		
		while(queue.size() != 0){
			IGroup tmpGroup = queue.poll();
			List<IGroup> subs = tmpGroup.getSubGroups();
			removeChildGroupsFromList(subs, groupNames, queue);
		}
	}
	
	private void removeChildGroupsFromList(List<IGroup> subGroups, String[] groupNames, BlockingQueue<IGroup> queue){
		for(Iterator<IGroup> iter = subGroups.iterator();iter.hasNext();){
			boolean found = false;
			IGroup sub = iter.next();
			for(String name : groupNames){
				if(name.equals(sub.getName())){
					found = true;
					break;
				}
			}
			if(found){
				iter.remove();
			}else{
				queue.add(sub);
			}
		}
	}
}

class IGroup{
	String name;
	List<IGroup> subGroups;
	public IGroup(String name) {
		super();
		this.name = name;
		this.subGroups = new ArrayList();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<IGroup> getSubGroups() {
		return subGroups;
	}
	public void setSubGroups(List<IGroup> subGroups) {
		this.subGroups = subGroups;
	}
}