package org.hbrs.se1.ws24.uebung2.control;

import java.util.Collection;
import java.util.ArrayList;

public class Container {
	
	
	private Collection<Member> memberList = new ArrayList<>();
	
	
	public void addMember(Member member) throws ContainerException{
		for(Member m : memberList) {
			if(m.getID() == member.getID()) {
				throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits im Container vorhanden!");
			}
		}
		memberList.add(member);
	}
	
	
	public String deleteMember(int id) {
		for(Member m : memberList) {
			if(m.getID() == id) {
				if(memberList.remove(m) == true) {
					return "Das Member-Objekt mit der ID " + id + " wurde erfolgreich gelöscht";
				}
			}
		}
		return "Es existiert kein Member-Objekt mit der ID " + id + " im Container";
	}
	
	
	public void dump() {
		for (Member m : memberList) {
			System.out.println(m.toString());
		}
	}
	
	
	public int size() {
		return memberList.size();
	}


	public Collection<Member> getAllMembers() {
	    return memberList;
	}

	
}
