package org.hbrs.se1.ws24.uebung2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se1.ws24.uebung2.control.ConcreteMember;
import org.hbrs.se1.ws24.uebung2.control.Container;
import org.hbrs.se1.ws24.uebung2.control.ContainerException;
import org.hbrs.se1.ws24.uebung2.control.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestContainer {
	
    private Container container;
    private Member member1;
    private Member member2;

    @BeforeEach
    public void setUp() {
        container = new Container();
        member1 = new ConcreteMember(1); 
        member2 = new ConcreteMember(2); 
    }

    @Test
    public void testAddMember() throws ContainerException {
    	
    	// Test 1 pos add
        container.addMember(member1);
        assertEquals(1, container.getAllMembers().size());
        
        // Test 2 pos add
        container.addMember(member2);
        assertEquals(2, container.getAllMembers().size());
    }

    @Test
    public void testAddDuplicateMember() {
    	
    	// Test 3 neg add (Exception))
        try {
            container.addMember(member1);
            container.addMember(member1); 
            fail("Eine ContainerException sollte geworfen werden, wenn ein Member mit doppelter ID hinzugefügt wird.");
        } catch (ContainerException e) {
            assertEquals("Das Member-Objekt mit der ID 1 ist bereits im Container vorhanden!", e.getMessage());
        }
    }

    @Test
    public void testDeleteMember() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        
        // Test 4 pos delete
        container.deleteMember(member1.getID());
        assertEquals(1, container.getAllMembers().size());
        
        // Test 5 neg delete
        container.deleteMember(member1.getID());
        assertEquals(1, container.getAllMembers().size());
        
        // Test 6 pos delete
        container.deleteMember(member2.getID());
        assertEquals(0, container.getAllMembers().size());
        

    }
    
    @Test
    public void testDeleteMemberMessage() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        
        // Test 7 pos delete (Message)
        assertEquals("Das Member-Objekt mit der ID " + member1.getID() + " wurde erfolgreich gelöscht", container.deleteMember(member1.getID()));
        
        // Test 8 neg delete (Message)
        assertEquals("Es existiert kein Member-Objekt mit der ID " + member1.getID() + " im Container", container.deleteMember(member1.getID()));
        
    }
    
    @Test
    public void testDeleteMore() throws ContainerException {
    	container.addMember(member2);
    	
    	// Test 9 pos delete (Message)
    	assertEquals("Das Member-Objekt mit der ID " + member2.getID() + " wurde erfolgreich gelöscht", container.deleteMember(member2.getID()));
    	
    	// Test 10 neg delete (Message)
    	assertEquals("Es existiert kein Member-Objekt mit der ID " + member2.getID() + " im Container", container.deleteMember(member2.getID()));
    	
    	// Test 11 neg delete (delete with int id) 
    	assertEquals("Es existiert kein Member-Objekt mit der ID " + 3 + " im Container", container.deleteMember(3));
    }
}

