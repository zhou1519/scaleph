import admin from './admin';
import user from './user';
import studio from './studio';
import project from './project';
import resource from './resource';
import dataSource from "./dataSource";
import stdata from "./stdata";
export default {
  ...user,
  ...admin,
  ...studio,
  ...project,
  ...resource,
  ...dataSource,
  ...stdata,
};
