package handlers;

import dados.Drone;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DroneHandler {
	private final Set<Drone> drones;

	public DroneHandler() {
		drones = new TreeSet<>();
	}

	public boolean cadastraDrone(Drone d) {
		return drones.add(d);
	}

	public List<Drone> buscaTodos() {
		return List.copyOf(drones);
	}
}
