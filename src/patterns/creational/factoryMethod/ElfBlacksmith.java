package patterns.creational.factoryMethod;

public class ElfBlacksmith implements Blacksmith {
  public Weapon manufactureWeapon(WeaponType weaponType) {
    return new ElfWeapon(weaponType);
  }
}
