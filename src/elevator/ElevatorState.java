package elevator;

import common.*;
import event.toElevator.*;
import event.toScheduler.*;
import event.*;
/**
 * Abstract class that implements the base state for the elevator. Implements getters and setters as well as 
 * ensures that all states have some base functionality
 */
public abstract class ElevatorState {
	protected int currentFloor;
	protected Direction direction;
	protected DoorState doorState;
	protected LampState upLamp;
	protected LampState downLamp;
	protected LampState[] buttonLamps;
	
	
	/**
	 * Default constructor for an ElevatorState. This is considered the default state for an
	 * Elevator state
	 * 
	 * @param numberOfFloors number of floors the elevator must service
	 */
	public ElevatorState(int numberOfFloors) {
		this.currentFloor = 0;
		this.doorState = DoorState.OPEN;
		this.direction = Direction.IDLE;
		this.upLamp = LampState.OFF;
		this.downLamp = LampState.OFF;
		this.buttonLamps = new LampState[numberOfFloors];
		for (LampState buttonLamp: buttonLamps) {
			buttonLamp = LampState.OFF;
		}
	}
	
	/**
	 * Copy Constructor given a previous state
	 * @param state The state to copy into a new instance
	 */
	public ElevatorState(ElevatorState state) {
		this.currentFloor = state.currentFloor;
		this.doorState = state.doorState;
		this.direction = state.direction;
		this.upLamp = state.upLamp;
		this.downLamp = state.downLamp;
		this.buttonLamps = state.buttonLamps;
	}
	
	/**
	 * Default implementation for the handling of elevatorDirectionLampEvent
	 * @param elevatorDirectionLampEvent the event modeling the on/off of a direction lamp
	 */
	public ElevatorState handleElevatorDirectionLampEvent(ElevatorDirectionLampEvent changeLampStateEvent) {
		switch(elevatorDirectionLampEvent.getLampDirection()) {
			case UP:
				this.upLamp = elevatorDirectionLampEvent.getLampState();
				break;
			case DOWN:
				this.downLamp = elevatorDirectionLampEvent.getLampState();
				break;
		}
		return this;
	}
	
	/**
	 * Default implementation for the handling of ElevatorCloseDoorEvent
	 * @param elevatorDoorEvent the event modeling the opening/closing of a door
	 */
	public ElevatorState handleElevatorOpenDoorEvent(ElevatorOpenDoorEvent elevatorCloseDoorEvent) {
		return new ElevatorFailureState();
	}
	
	
	/**
	 * Default implementation for the handling of ElevatorOpenDoorEvent
	 * @param elevatorDoorEvent the event modeling the opening/closing of a door
	 */
	public ElevatorState handleElevatorCloseDoorEvent(ElevatorCloseDoorEvent elevatorCloseDoorEvent) {
		return new ElevatorFailureState();
	}
	
	
	/**
	 * Default implementation for the handling of elevatorTransitEvent
	 * @param elevatorTransitEvent the event modeling the acceleration/deceleration of an elevator
	 */
	public ElevatorState handleElevatorKeepMovingEvent(ElevatorKeepMovingEvent elevatorKeepMovingEvent) {
		return new ElevatorFailureState();
	}
	
	/**
	 * Default implementation for the handling of elevatorTransitEvent
	 * @param elevatorTransitEvent the event modeling the acceleration/deceleration of an elevator
	 */
	public ElevatorState handleElevatorStartMovingEvent(ElevatorStartMovingEvent elevatorStartMovingEvent) {
		return new ElevatorFailureState();
	}
	
	/**
	 * Default implementation for the handling of elevatorTransitEvent
	 * @param elevatorTransitEvent the event modeling the acceleration/deceleration of an elevator
	 */
	public ElevatorState handleElevatorStopMovingEvent(ElevatorStopMovingEvent elevatorStopMovingEvent) {
		return new ElevatorFailureState();
	}
	
	/**
	 * Default implementation for the handling of elevatorTransitEvent
	 * @param elevatorTransitEvent the event modeling the acceleration/deceleration of an elevator
	 */
	public ElevatorState handleElevatorPressButtonEvent(ElevatorStopMovingEvent elevatorStopMovingEvent) {
		return new ElevatorFailureState();
	}
	
	public int getCurrentFloor() {
		return this.currentFloor;
	}
}