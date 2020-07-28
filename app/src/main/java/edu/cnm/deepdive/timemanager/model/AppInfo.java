//package edu.cnm.deepdive.timemanager.model;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//public class AppInfo implements Comparable<AppInfo> {
//
//  private static final String FORMAT = "%s [%s]";
//
//  @NonNull
//  private String pkg = "";
//  @NonNull
//  private String label = "";
//  private Integer hash;
//
//  @NonNull
//  public String getPackage() {
//    return pkg;
//  }
//
//  public void setPackage(@NonNull String pkg) {
//    this.pkg = pkg;
//    hash = null;
//  }
//
//  @NonNull
//  public String getLabel() {
//    return label;
//  }
//
//  public void setLabel(@NonNull String label) {
//    this.label = label;
//    hash = null;
//  }
//
//  @Override
//  public int hashCode() {
//    if (hash == null) {
//      hash = 31 * pkg.toUpperCase().hashCode() + label.toUpperCase().hashCode();
//    }
//    return hash;
//  }
//
//  @Override
//  public boolean equals(@Nullable Object obj) {
//    boolean comparison = false;
//    if (obj == this) {
//      comparison = true;
//    } else if (obj instanceof edu.cnm.deepdive.timemanager.model.AppInfo) {
//      edu.cnm.deepdive.timemanager.model.AppInfo other = (edu.cnm.deepdive.timemanager.model.AppInfo) obj;
//      comparison = other.pkg.equalsIgnoreCase(pkg) && other.label.equalsIgnoreCase(label);
//    }
//    return comparison;
//  }
//
//  @NonNull
//  @Override
//  public String toString() {
//    return String.format(FORMAT, label, pkg);
//  }
//
//  @Override
//  public int compareTo(edu.cnm.deepdive.timemanager.model.AppInfo other) {
//    int comparison = label.compareToIgnoreCase(other.label);
//    if (comparison == 0) {
//      comparison = pkg.compareToIgnoreCase(other.pkg);
//    }
//    return comparison;
//  }
//
//}
